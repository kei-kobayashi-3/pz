hw = gets.split.map{|s|s.to_i}

h = hw[0]
w = hw[1]
input = []

i = h
while i > 0
    input << gets.chomp.split("")
    i -= 1
end

# @return input 周りを海に囲まれたinput多重配列
# @return islands 島の位置を示す配列
def ini_process(h, w, input)
  # 周りが海に囲まれているので周りに海を作成する
  input.map!{|ar| ar.unshift(".") }
  input.map!{|ar| ar << "."}
  input.unshift(Array.new(w+2){|i| "."})
  input << Array.new(w+2){|i| "."}

  islands = []
  for i in (0..h+1)
    for j in (0..w+1)
      if input[i][j] == "#"
        islands << [i, j]
      end
    end
  end
  return input, islands
end

# depth-first search
# @start 調査を開始するisland
def dfs(input, start, visited)
  # 今回の結果を記録する
  area = 0
  coastline = 0
  # 調査するスタック
  stack = [start]
  # stackが空になるまで繰り返す
  while stack.length > 0
    node = stack.pop
    # 既に訪問済みであればスキップする
    next if visited.include?(node)
    # 訪問済みにnodeを追加する
    visited << node
    area += 1
    # 隣接する未訪問の島をスタックに追加する その際に海だったら海岸線を追加する
    # 左
    node_left = [node[0], node[1]-1]
    a, b = node_left
    if input[a][b] == "."
      coastline += 1
    else
      stack << node_left unless visited.include?(node_left)
    end
    # 上
    node_up = [node[0]-1, node[1]]
    a, b = node_up
    if input[a][b] == "."
      coastline += 1
    else
      stack << node_up unless visited.include?(node_up)
    end
     # 右
     node_right = [node[0], node[1]+1]
     a, b = node_right
     if input[a][b] == "."
       coastline += 1
     else
       stack << node_right unless visited.include?(node_right)
     end
      # 下
    node_down = [node[0]+1, node[1]]
    a, b = node_down
    if input[a][b] == "."
      coastline += 1
    else
      stack << node_down unless visited.include?(node_down)
    end
  end
  return visited, area, coastline
end

# 訪問済みの島を入れる配列
visited = []
# 結果を入れる配列
result = []

input, islands = ini_process(h, w, input)

for island in islands
  unless visited.include?(island)
    visited, area, coastline = dfs(input, island, visited)
    visited += visited
    result << [area, coastline]
  end
end

result.sort_by!{|a, b| [-a, -b]}
for s in result
    puts s.join(" ")
end
