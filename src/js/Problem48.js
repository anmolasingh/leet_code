/* 
    Approach 1 - Create Transpose of matrix and then replace columns one by
*/

var rotate = function(matrix) {
    for(var i =0; i< matrix.length; i++){
        for(var j =0; j < i; j++){
            const temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }
      
  
    for(var i =0; i< matrix.length; i++){
        for(var j =0; j < Math.floor(matrix.length/2); j++){
            const temp = matrix[i][j];
            matrix[i][j] = matrix[i][matrix.length-1-j];
            matrix[i][matrix.length-1-j] = temp;
        }
    }
    return matrix;
};