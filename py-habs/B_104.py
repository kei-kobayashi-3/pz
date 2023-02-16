import pandas as pd
import numpy as np

start = input().split(" ")
N = int(start[0])
M = int(start[1])

d_rows = [input() for i in range(N)]
d_mat = pd.DataFrame([j.split(" ") for j in d_rows])


# for i in range(M):
#     d_mat[i] = pd.to_numeric(d_mat[i], errors = "coerce")

nu = lambda x: int(x) if x.isdigit() else None
d_mat = d_mat.applymap(nu)


or_d = lambda x: None if x < 0 or x > 100  else x
d_mat = d_mat.applymap(or_d)



sr = d_mat.mean(axis = 0).astype(int)

[print(s) for s in sr]
