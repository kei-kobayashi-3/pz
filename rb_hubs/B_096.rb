h,w = gets.split(" ").map(&:to_i)


class Input
    attr_accessor :n_rows, :n_cols
    def initialize(h,w)
        @n_rows = h
        @n_cols = w
    end

    def field
        rows = []
        n_rows.times do
            rows << gets.chomp.split("")
        end
        return rows
    end
end

def bomb_index(row)
    row.each_index.select{|i| row[i] == "#"}
end

def bomb_indexs(rows)
    indexs = []
    col_indexs = []
    rows.each_with_index do |row,i|
        indexs = bomb_index(row) | indexs
        col_indexs << (row.include?("#") ? i : nil)
    end
    return indexs, col_indexs.compact
end

def result(row_inx,col_inx,h,w)
    return col_inx.length * h if row_inx == []
    return row_inx.length * w if col_inx == []
    row_inx.length * w + col_inx.length * h - (col_inx.length * row_inx.length )
end




input = Input.new(h,w)
y,x= bomb_indexs(input.field)

puts result(x, y,h,w)
