h,w = gets.split(" ").map(&:to_i)

rowss = []
h.times do
    rowss << gets.split(" ").map(&:to_i)
end
a = [1,2]

rows = rowss.reverse
result = Array.new(w){0}

(h - 1).times do |i|
    rows[i].each_with_index do |row, j|
        if j == 0
            result[j] = rows[i][0..1].max + rows[i+1][j]
        elsif j == (w - 1)
            result[j] = rows[i][(w-2)..(w-1)].max + rows[i+1][j]
        else
            result[j] = rows[i][(j-1)..(j+1)].max + rows[i+1][j]
        end

    end
    rows[i + 1] = result.clone

end
p result.max
