# --------------------------------------------------------------------------------------------------------
#                                         IMPORTING LIBRARIES

import mysql.connector as connection
import connectMysql as conn

# --------------------------------------------------------------------------------------------------------

def getChats(mydb):
    conversationHistory = []
    try:
        query = "SELECT PROMPT, RESPONSE FROM CHATBOT_CONVERSATION"
        cursor = mydb.cursor()
        cursor.execute(query)
        rows = cursor.fetchall()
        
        for row in rows:
            prompt, response = row
            conversationHistory.append({
                "role": "user",
                "parts": [prompt]
            })
            conversationHistory.append({
                "role": "model",
                "parts": [response]
            })
        
        return conversationHistory
    except connection.Error as error:
        print(error)

# mydb = conn.connect_to_mysql()           
# print(getChats(mydb))