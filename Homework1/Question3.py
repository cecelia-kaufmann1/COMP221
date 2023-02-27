from imageTools import *
import numpy as np
import math

BE = Picture("SampleImages/baldEagle.jpg")
BE.save("baldEagle1.jpg")
def sobelfilter(newPic):
    rows = newPic.getWidth()
    cols = newPic.getHeight()
    newPicture = Picture(rows, cols)
    for x in range(1, rows-1):
        for y in range(1, cols-1):
            (r, g, b) = newPic.getColor(x - 1, y -1)
            rgb1 = (r * -1, g * -1,  b * -1)
            (r, g, b) = newPic.getColor(x, y - 1)
            rgb2 = (r * 0, g * 0, b * 0)
            (r, g, b) = newPic.getColor(x-1, y)
            rgb3 = (r * 1, g * 1, b * 1)
            (r, g, b) = newPic.getColor(x-1, y)
            rgb4 = (r * -2, g * -2, b * -2)
            (r, g, b) = newPic.getColor(x, y)
            rgb5 = (r * 0, g * 0, b * 0)
            (r, g, b) = newPic.getColor(x + 1, y)
            rgb6 = (r * 2, g * 2, b * 2)
            (r, g, b) = newPic.getColor(x - 1, y + 1)
            rgb7 = (r * -1, g * -1, b * -1)
            (r, g, b) = newPic.getColor(x, y + 1)
            rgb8 = (r * 0, g * 0, b * 0)
            (r, g, b) = newPic.getColor(x+ 1, y + 1)
            rgb9 = (r * 1, g * 1, b * 1)
            sumRedx = rgb1[0] + rgb2[0] + rgb3[0] + rgb4[0] + rgb5[0] + rgb6[0] + rgb7[0] + rgb8[0] + rgb9[0]
            sumGreenx = rgb1[1] + rgb2[1] + rgb3[1] + rgb4[1] + rgb5[1] + rgb6[1] + rgb7[1] + rgb8[1] + rgb9[1]
            sumBluex = rgb1[2] + rgb2[2] + rgb3[2] + rgb4[2] + rgb5[2] + rgb6[2] + rgb7[2] + rgb8[2] + rgb9[2]
            sumX = (sumRedx + sumGreenx + sumBluex) / 3
            (r, g, b) = newPic.getColor(x - 1, y - 1)
            yrgb1 = (r * 1, g * 1, b * 1)
            (r, g, b) = newPic.getColor(x, y - 1)
            yrgb2 = (r * 2, g * 2, b * 2)
            (r, g, b) = newPic.getColor(x - 1, y)
            yrgb3 = (r * 1, g * 1, b * 1)
            (r, g, b) = newPic.getColor(x - 1, y)
            yrgb4 = (r * 0, g * 0, b * 0)
            (r, g, b) = newPic.getColor(x, y)
            yrgb5 = (r * 0, g * 0, b * 0)
            (r, g, b) = newPic.getColor(x + 1, y)
            yrgb6 = (r * 0, g * 0, b * 0)
            (r, g, b) = newPic.getColor(x - 1, y + 1)
            yrgb7 = (r * -1, g * -1, b * -1)
            (r, g, b) = newPic.getColor(x, y + 1)
            yrgb8 = (r * -2, g * -2, b * -2)
            (r, g, b) = newPic.getColor(x + 1, y + 1)
            yrgb9 = (r * -1, g * -1, b * -1)
            sumRedy = yrgb1[0] + yrgb2[0] + yrgb3[0] + yrgb4[0] + yrgb5[0] + yrgb6[0] + yrgb7[0] + yrgb8[0] + yrgb9[0]
            sumGreeny = yrgb1[1] + yrgb2[1] + yrgb3[1] + yrgb4[1] + yrgb5[1] + yrgb6[1] + yrgb7[1] + yrgb8[1] + yrgb9[1]
            sumBluey = yrgb1[2] + yrgb2[2] + yrgb3[2] + yrgb4[2] + yrgb5[2] + yrgb6[2] + yrgb7[2] + yrgb8[2] + yrgb9[2]
            sumY = (sumRedy + sumGreeny + sumBluey) / 3
            newG = math.sqrt((sumX)**2 + (sumY)** 2)
            newPicture.setColor(x, y, (newG, newG, newG))
    return newPicture

BE.show()
newBE = sobelfilter(BE)
newBE.show()
newBE.save("coolBaldEagle.jpg")
input()