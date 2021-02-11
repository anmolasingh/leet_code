
function maximumProfit(arr) {

    let low = arr[0];
    let high = arr[0];
    
    let maxProfit = 0;

    for(let i=1; i<arr.length; ++i) {
        if(arr[i] < low) {
            low = arr[i];
            high = arr[i];
        } else {
            high = arr[i];
            const currentProfit = high - low;
            if(currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }
        }
    }

    return maxProfit;
}

let profit = maximumProfit([7, 5, 3, 6, 1, 3]);

console.log(profit, "profit");