def transpose(A):
    row, col = len(A), len(A[0])
    dp = [[0] * row for _ in range(col)]
    for i in range(row):
        for j in range(col):
            dp[j][i] = A[i][j]
    return dp

# A = [[1,2,3,4], [5,6,7,8], [9,10,11,12], [-1, -2, -3, -4]]
# At = transpose(A)
# print(A)
# print('is transposed to')
# print(At)