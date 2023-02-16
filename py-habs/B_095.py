import pandas as pd
import numpy as np


n = input().split(" ")
N = int(n[0])
M = int(n[1])

r_score = [int(input()) for x in range(M)]
r_df = pd.DataFrame(r_score)
df = pd.DataFrame([[int(input()) for y in range(M)] for z in range(N)]).T


for i in range(N):
    df[i] = df[i] - r_df[0]

df = df.abs()

def cal(x):
    if x <= 5:
        return 0
    elif x <= 10:
        return -1
    elif x <= 20:
        return -2
    elif x <= 30:
        return -3
    else:
        return -5

res = []
for j in range(N):
    df[j] = df[j].apply(cal)
    res.append(100 + sum(df[j]))

rr =  max(res)
if rr > 0:
    print(rr)
else:
    print(0)
