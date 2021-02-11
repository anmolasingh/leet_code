'use strict';
function sortColors(arr) {
    let low=0, mid = 0, high = arr.length-1;
    while(mid <= high) {
        if(arr[mid] === 0) {
            const temp = arr[mid];
            arr[mid] = arr[low];
            arr[low] = temp;
            low++;
            mid++;
        } else if(arr[mid] === 1) {
            mid++;
        } else {
            const temp = arr[high];
            arr[high] = arr[mid];
            arr[mid] = temp;
            high--;
        }
    }
}

let arr = [1,2,0,1];

sortColors(arr);

console.log(arr, "Arr");