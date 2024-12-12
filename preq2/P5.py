def gauss_jordan(A, b):
    n = len(A)
    
    augmented = [A[i] + b[i] for i in range(n)]
    
    for i in range(n):
        pivot = augmented[i][i]
        if pivot == 0:
            return None
        
        augmented[i] = [x / pivot for x in augmented[i]]
        
        
        for j in range(n):
            if i != j:
                factor = augmented[j][i]
                augmented[j] = [augmented[j][k] - factor * augmented[i][k] for k in range(n + 1)]
    
    solution = [augmented[i][n] for i in range(n)]

    return [[round(x,4)] for x in solution]


# A = [[4,1,1], [1, 2, -2], [1, 2, 3]]
# b = [[6], [9], [10]]
# x = gauss_jordan(A,b)
# print('Gaussian-Jordan elimination:')
# print("A=", A)
# print("b=", b)
# print("x=", x)