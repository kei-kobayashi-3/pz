import pandas as pd

ar = input().split(" ")
N = int(ar[0])
Pre = int(ar[1])

r = [input() for x in range(N)]

df = pd.DataFrame([x.split(" ") for x in r])
df = df.astype(int)


res=[]
for i in range(N):
    if max(df[i]) < Pre:
        res.append(i+1)


if res == []:
    print("wait")

else:
    print(" ".join([str(x) for x in res]))
