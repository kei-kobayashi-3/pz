n,@x = gets.split(" ").map(&:to_i)
hash ={}
1.upto(n) do |i|
    w, r = gets.split(" ").map(&:to_i)
    hash[i] = {w => r}
end



def sum_v(hash)
    sum_value = 0
    vals = []
    kess = []
    hash.values.each do |k|
        sum_value += k.values[0]
        vals << k.values[0]
        kess << k.keys[0]
    end
    return sum_value,vals,kess.sum
end

def confirm(sum_value)
    @x < sum_value
end

def delete_hash(hash)
    s,vs,ks = sum_v(hash)

    while confirm(ks)
        re = []
        s,vs,ks = sum_v(hash)

        hash.values.each do |h|
            if h.values[0] == vs.min
                re << h.keys[0]
            end
        end
        hash.delete_if{|k,v| v == {re.max => vs.min}}
        s,vs,ks = sum_v(hash)
        return s unless confirm(ks)
    end

end

p delete_hash(hash)









# tar_key = []
# hash.each do |key,val|
#     tar_key <<
