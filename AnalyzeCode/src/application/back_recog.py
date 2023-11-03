#example
# carrot.jpg
# tomatoes.png
# potato.jpg
# Broccoli_2.jpg


import keras
from keras.models import load_model
import keras.utils as image
import numpy as np

def predict(filepath):
  # dimensions of our images
  img_width, img_height = 256, 256
  # img_width, img_height = 224, 224

  # load the model we saved
  # model = load_model('/content/drive/MyDrive/sophomore/上學期/系統分析與設計/model_test/best_model.h5')
  model = load_model('model\ResNet50V2- Vegetable-Classifier.h5')

  model.compile(loss='binary_crossentropy',
                optimizer='rmsprop',
                metrics=['accuracy'])

  # predicting images
  img = image.load_img(filepath, target_size=(img_width, img_height))
  x = image.img_to_array(img)
  x = np.expand_dims(x, axis=0)
  x /= 255.

  predict_y1 = model.predict(x)
  classes = ['Bean', 'Bitter_Gourd', 'Bottle_Gourd', 'Brinjal', 'Broccoli', 'Cabbage', 'Capsicum', 'Carrot', 'Cauliflower', 'Cucumber', 'Papaya', 'Potato', 'Pumpkin', 'Radish', 'Tomato']
  # classes = [ 'apple', 'banana', 'carrot', 'cauliflower', 'no detection', 'potato']

  prediction = predict_y1[0]
  noDetect = True
  class_detected = []
  index_detected = []
  for i, pre in enumerate(prediction):
    if pre>0.5:
      class_detected.append(classes[i]) 
      index_detected.append(i)
      noDetect = False
  # print(prediction[7])
  if noDetect:
    return "no detection"
  else:
    str_class_detected = ""
    for i in class_detected:
      str_class_detected += i + " "
    return str_class_detected