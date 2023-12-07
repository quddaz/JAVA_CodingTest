def function(N):
    if N == 1:
        return 0,1
    else:
        x,y = function(N-1)
        return x+y,x
    
N = int(input())
x,y = function(N)

print(str(x+y))
