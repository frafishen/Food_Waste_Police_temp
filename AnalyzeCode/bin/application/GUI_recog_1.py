import tkinter as tk
from tkinter import StringVar, filedialog
import back_recog
import cv2 as cv


class App():


    def __init__(self):
        self.window = tk.Tk()
        self.window.title('首頁')
        self.window.geometry('330x600')
        self.window.resizable(False, False)
        self.window.configure(bg='lavender blush')

        label = tk.Label(self.window, text = '吃到飽剩食辨識系統', font = ("microsoft yahei", 17, "bold"), fg="HotPink4", bg='lavender blush')
        label.place(x=58,y=20)



        photo1 = tk.PhotoImage(file="img/table.png")
        imgLabel = tk.Label(image=photo1, bg='lavender blush')
        imgLabel.place(x=50, y=85)

        label = tk.Label(self.window, text = '桌號：', font = ("microsoft yahei", 12), fg="HotPink4", bg='lavender blush')
        label.place(x=80,y=85)

        
        entry = tk.Entry(self.window)
        entry.place(x=130,y=89)


        photo2 = tk.PhotoImage(file="img/photo-camera.png")
        btn1 = tk.Button(image=photo2, bg='snow', command=lambda: self.take_photo(entry.get()))
        btn1.place(x=80,y=250)

        photo3 = tk.PhotoImage(file="img/gallery.png")
        btn1 = tk.Button(image=photo3, bg='snow', command=lambda: self.browse_button(entry.get()))
        btn1.place(x=180,y=250)


        self.window.mainloop()

    def browse_button(self, table_number):

        
        filepath = filedialog.askopenfilename()
        print(filepath)
        img = back_recog.predict(filepath)
        print(img)
        self.window.destroy()

        from GUI_recog_2 import App2
        app2 = App2(img, filepath, table_number)

    def take_photo(self, table_number):
        cam = cv.VideoCapture(0)
        result, image = cam.read()
        if result:
            filepath = "img/test.png"
            cv.imwrite(filepath, image)
            img = back_recog.predict(filepath)
            print("Saved photo")
            self.window.destroy()
            from GUI_recog_2 import App2
            app2 = App2(img, filepath, table_number)

    
        


if __name__ == '__main__':
    app = App()

