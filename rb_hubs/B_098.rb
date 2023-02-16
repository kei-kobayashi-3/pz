n,m,t,k = gets.split(" ").map(&:to_i)
lis = []
m.times {lis << gets.split(" ") }

n.times do |i|
    liss = lis.map{|ll| ll[i].to_i}

    0.upto(liss.length - t) do |j|
        x = 0
        exi = 0
        j.upto(t+j-1) do |m|
            x += liss[m]
            if x >= k
                puts "yes #{m+1}"
                exi = 1
                break
            end
        end
    break if exi == 1
    puts "no 0" if j == liss.length - t
    end
end
