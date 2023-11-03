import tkinter as tk
from PIL import Image, ImageTk
from datetime import datetime
import random, string
import pandas as pd


class App2():


    def callback(self):
        self.window.destroy()
        from GUI_recog_1 import App
        app = App()

    def upload_food(self, timeStamp, table_number, recog_result, str_random):
        df_exist = pd.read_csv('food_recog.csv')
        dict_recog = {'timeStamp': timeStamp, 'table_number': table_number, 'recog_result': recog_result, 'str_random': str_random}
        # list_upload = [timeStamp, table_number, recog_result, str_random]

        df_exist = df_exist.drop(['Unnamed: 0'], axis=1)
        df_upload = pd.concat([df_exist, pd.DataFrame([dict_recog])], axis=0).reset_index(drop=True)
        # df_upload.reset_index(drop=True)
        df_upload.to_csv('food_recog.csv')
        print("upload success")


    def __init__(self, img, filepath, table_number):

        self.window = tk.Tk()
        self.window.title('辨識結果')
        self.window.geometry('330x600')
        self.window.resizable(False, False)
        self.window.configure(bg='lavender blush')


        label0 = tk.Label(self.window, text="辨識結果:", fg='HotPink4', font=('microsoft yahei',20,'bold'), bg='lavender blush')
        now = datetime.now()
        current_time = now.strftime("%H:%M:%S")
        label1 = tk.Label(self.window,bitmap='info',compound="left", text='  時間 ：%s'%(current_time), fg='HotPink4', font=('microsoft yahei',14,'bold'), bg='lavender blush')
        label2 = tk.Label(self.window,bitmap='info',compound="left", text='  桌號 ：%s'%(table_number), fg='HotPink4', font=('microsoft yahei',14,'bold'), bg='lavender blush')
        label3 = tk.Label(self.window,bitmap='info',compound="left", text='  食物辨識結果 ：%s'%(img), fg='HotPink4', font=('microsoft yahei',14,'bold'), bg='lavender blush')
        img_food = Image.open(filepath)
        tk_img_food = ImageTk.PhotoImage(img_food.resize((230, 230)))
        label_img_food = tk.Label(self.window, image=tk_img_food)
        label_img_food.image = tk_img_food
        label_img_food.pack()
        str_random = ''.join(random.sample(string.ascii_letters + string.digits, 10))
        label4 = tk.Label(self.window,bitmap='info',compound="left", text='  拍照序號 ：%s'%(str_random), fg='HotPink4', font=('microsoft yahei',14,'bold'), bg='lavender blush')
        btn1 = tk.Button(self.window,text='回上頁',width=6,height=1, font=('microsoft yahei',10), command=self.callback)
        btn2 = tk.Button(self.window, text='上傳',width=6,height=1, font=('microsoft yahei',10), command=lambda: self.upload_food(current_time, table_number, img, str_random))

        label0.place(x=110,y=10)
        label1.place(x=55,y=70)
        label2.place(x=55,y=115)
        label3.place(x=55,y=160)
        label4.place(x=55,y=450)
        btn1.place(x=80,y=520)
        btn2.place(x=190,y=520)
        label_img_food.place(x=55,y=205)



        
        self.window.mainloop()
    
    
        