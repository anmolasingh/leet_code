var lengthOfLongestSubstring = function(s) {
    let map = {}, maxLength = 0, lastPosition = 0;
    for(let i=0; i<s.length; ++i) {
        let char = s.charAt(i);
        if(typeof map[char] !== 'undefined') {
            const mapLength = Object.keys(map).length;
            if(mapLength > maxLength) {
                maxLength = mapLength;
            }
            const pos = map[char];
            for(let j=lastPosition; j<=map[char]; ++j) {
                const char2 = s.charAt(j);
                delete map[char2];
            }
            lastPosition = pos + 1;
        }
        map[char] = i;
        
    }
    console.log(map, "map");
    const mapLength = Object.keys(map).length;
    if(mapLength > maxLength) {
        maxLength = mapLength;
    }
    return maxLength;
};