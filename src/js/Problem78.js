/*
    Approach 1:
    DFS approach
*/

let nums = [1,2];

function findSubsets(arr) {
    let subsets = [];
    generateSubsets(0, arr, [], subsets);
    return subsets;
}

function generateSubsets(index, nums, current, subsets) {
    subsets.push([...current]);
    for(let i=index; i<nums.length; ++i) {
        current.push(nums[i]);
        generateSubsets(i+1, nums, current, subsets);
        current.pop();
    }
}

console.log(findSubsets(nums));

/*
    Approach 2: Iterative Approach
    [[]]
    1-> [[], [1]]
    2-> [[], [1], [2], [1,2]]
    3-> [[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]]
*/

function findSubsets(nums) {
    let result = [[]];
    for(let i=0; i<nums.length; ++i) {
        let temp1 = [];
        for(let j=0;j<result.length; ++j) {
            let temp = [...result[j]];
            temp.push(nums[i]);
            temp1.push(temp);
        }
        result.push(...temp1);
    }
    return result;
}

console.log(findSubsets([1,2,3]))