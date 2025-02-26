# --------------------------------------------------------------------------------------------------------
#                                         IMPORTING LIBRARIES

import mysql.connector as connection

# --------------------------------------------------------------------------------------------------------

def uploadChat(mydb, prompt, response):
    mycursor = mydb.cursor()
    try:
        # INSERTION QUERY
        query = "INSERT INTO CHATBOT_CONVERSATION(PROMPT, RESPONSE) VALUES (%s, %s)"
        mycursor.execute(query, (prompt, response))
        mydb.commit()
    except connection.Error as error:
        print(error)