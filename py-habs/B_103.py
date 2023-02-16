import numpy as np

N = int(input())
s = [input() for i in range(N+1)]
r_beatle_loc = int(s[0].split(' ')[0])
g_beatle_loc = int(s[0].split(' ')[1])
b_beatle_loc = int(s[0].split(' ')[2])

class Beatle:
    def __init__(self,loc):
        self.loc  = loc

r_beatle = Beatle(r_beatle_loc)
g_beatle = Beatle(g_beatle_loc)
b_beatle = Beatle(b_beatle_loc)

run = {r_beatle:["R","Y","M","W"],g_beatle:["G","Y","C","W"],b_beatle:["B","M","C","W"]}

s = s[1:]
for k,j in enumerate(s):
    L_R = j.split(' ')[0]
    color = j.split(' ')[1]
    for key in run.keys():
        if color in run[key]:
            if L_R == "L":
                key.loc -= 1
            elif L_R == "R":
                key.loc += 1
    if r_beatle.loc == g_beatle.loc and g_beatle.loc == b_beatle.loc:
        print(r_beatle.loc)
        break
    if k == len(s)-1:
        print("no")
