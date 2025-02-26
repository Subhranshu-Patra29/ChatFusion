# --------------------------------------------------------------------------------------------------------
#                                         IMPORTING LIBRARIES

import connectMysql as conn

import google.generativeai as genai
import logging

import uploadConversation
import getConversationHistory

# --------------------------------------------------------------------------------------------------------

# Connect to database
mydb = conn.connect_to_mysql()

# ---------------------------------------------------------------------------------------------------------

# api_key="AIzaSyA3C-MwLwMy0hK_p4N-xN-vajWsuoF4S-4"
conversationHistory = getConversationHistory.getChats(mydb)

def connect():
  global api_key
  try:
    genai.configure(api_key="AIzaSyA3C-MwLwMy0hK_p4N-xN-vajWsuoF4S-4")

    # Create the model
    generation_config = {
      "temperature": 0.5,
      "top_p": 0.95,
      "top_k": 64,
      "max_output_tokens": 250,
      "response_mime_type": "text/plain",
    }

    safety_settings = getSafetySettings()
    
    model = genai.GenerativeModel(
  model_name="gemini-1.5-pro",
  generation_config=generation_config,
  safety_settings = safety_settings,
  system_instruction="Your name is Samarth. You are a conversation assistant who works for ChatFusion and helps in providing meaningful replies after analysing the conversation flow and emotions. DON'T ever tell you are an AI.\n1. Your responses should be particularly for the INDIAN audience and hence should have a slight touch of the INDIAN culture.\n2. You should reply like a human and not use any phrases like 'How can I assist you today?' or anything similar to do this. ALWAYS TRY TO MAINTAIN HUMAN LIKE INTERACTION.\n3. Samvaad should use a conversational, friendly, casual tone while adapting to the user's mood and context. When responding, Samvaad should aim for natural-sounding language, avoiding repetitive patterns, and infuse light humor when appropriate to keep the conversation engaging. \n4. Samvaad should demonstrate empathy, recognize emotional cues, and tailor responses accordingly, whether the user seems frustrated, excited, or curious.\n5. Samvaad to offer helpful suggestions or resources when relevant, without being too intrusive or overbearing.\n6. Try to understand the GenZ short forms and reply similarly.\n7. DON'T USE THESE TYPE OF LINES -  Let's break down what's happening in this code and see what we can learn from it. OR Let me know if you want to explore specific aspects of the code or want to experiment with other scenarios. ",
  tools='code_execution',
)

    return model
  except Exception as e:
    logging.error(f"Error connecting to Gemini: {e}")
    return None

def getSafetySettings():
  safety = [
    {
      "category" : "HARM_CATEGORY_HATE_SPEECH",
      "threshold" : "BLOCK_ONLY_HIGH"
    },
    {
      "category" : "HARM_CATEGORY_DANGEROUS_CONTENT",
      "threshold" : "BLOCK_ONLY_HIGH"
    },
    {
      "category" : "HARM_CATEGORY_SEXUALLY_EXPLICIT",
      "threshold" : "BLOCK_ONLY_HIGH"
    },
    {
      "category" : "HARM_CATEGORY_HARASSMENT",
      "threshold" : "BLOCK_ONLY_HIGH"
    }
  ]
  return safety


def createChatSession(prompt):
  global conversationHistory
  
  # Establish Connection with the Gemini model
  model = connect()
  
  edited_prompt = prompt + "\nWithin 200 words"
  
  if model:   
      
    # Create the Chat Session with history fetched from mysql database from previous gpt interactions  
    chat_session = model.start_chat(
      history = conversationHistory
    )
    
    # Get the response from gemini
    response = chat_session.send_message(edited_prompt)
    # print(response.text)
    
    # Add the response to conversation history
    # conversationHistory += prompt + "\n" + response.text + "\n"
    uploadConversation.uploadChat(mydb, prompt, response.text)
    
    return response.text
      
  
def main():
  try:
        # prompt = input("Enter prompt: ")
        prompt = input()
        response = createChatSession(prompt)
        print(response)
  except Exception as e:
        logging.error(f"Error in main function: {e}")

if __name__ == "__main__":
    main() 