def matdot(A, B):

    if len(A[0]) != len(B):
        return None

    m = len(A)        
    n = len(B[0])     
    p = len(B)        

    C = [[0 for _ in range(n)] for _ in range(m)]

    for i in range(m):
        for j in range(n):
            for k in range(p):
                C[i][j] += A[i][k] * B[k][j]

    return C

# A = [[1, 2, 3], [-1, 0, 4]]
# B = [[10, 20], [5, -2], [7, 9]]
# M = [[8], [6]]
# AB = matdot(A, B)
# BA = matdot(B, A)
# AM = matdot(A, M)
# BM = matdot(B, M)
# print('A=', A)
# print('B=', B)
# print('A dot B =', AB)
# print('B dot A =', BA)
# print('A dot M =', AM)
# print('B dot M =', BM)