def function(N, List):
    List.sort(reverse=True)

    for i in range(N-2):
        if List[i] < (List[i+1] + List[i+2]) and List[i+1] < (List[i] + List[i+2]) and List[i+2] < (List[i+1] + List[i]):
            return List[i] + List[i+1] + List[i+2]

    return -1

N = int(input())
List = [int(input()) for _ in range(N)]

result = function(N, List)
print(str(result))