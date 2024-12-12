def swoprow(mat, row1, row2):
    matcopy = [row[:] for row in mat]
    matcopy[row1], matcopy[row2] = matcopy[row2], matcopy[row1]
    return matcopy

# A = [[1,2,3,4], [5,6,7,8], [9,10,11,12], [-1, -2, -3, -4]]
# print(A)
# print('After swop')
# Ap = swoprow(A, 0, 3)
# print('A=', A)
# print("A'=", Ap)