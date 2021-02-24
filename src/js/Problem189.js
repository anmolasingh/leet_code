/*
    Approach 1:
    Shift each element one by one and in every iteration we rotate the array by one step till k
*/
var rotate = function(nums, k) {
    for(let i=0; i<k; ++i) {
        let temp = nums[0];
        for(let j=1;j<=nums.length;++j) {
            let pos = j;
            let temp1 = nums[pos];
            if(pos > nums.length - 1) {
                pos = 0;
            }
            nums[pos] = temp;
            temp = temp1;
        }
    }
};

/*
    Approach 2:
    Use native javascript methods to splice from the end and push the resulting array in the front
*/
var rotate = function(nums, k) {
    nums.unshift(...nums.splice(nums.length - k, k))
};