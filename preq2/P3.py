def determinant(matrix, memo=None):
    if memo is None:
        memo = {}

    n = len(matrix)

    if n == 2:
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]
    
    matrix_tuple = tuple(tuple(row) for row in matrix)
    if matrix_tuple in memo:
        return memo[matrix_tuple]

    det = 0
    for col in range(n):
        minor = [row[:col] + row[col+1:] for row in matrix[1:]]
        
        det += (-1) ** col * matrix[0][col] * determinant(minor, memo)
    
    memo[matrix_tuple] = det
    
    return det

# A = [[3, 4, 5], [1, -1, 0], [8, 2, 7]]
# detA = determinant(A)
# B = [[1, 2, 3, 4], [-1, 0, 0.5, 9], [0, -6, 0.7, 0.5], [4, 4, 2, 1]]
# detB = determinant(B)
# C = [[3, 4, 5], [1, -1, 0], [-7, 7, 0]]
# detC = determinant(C)
# print('A =', A)
# print('det A =', detA)
# print('B =', B)
# print('det B =', detB)
# print('C =', C)
# print('det C =', detC)