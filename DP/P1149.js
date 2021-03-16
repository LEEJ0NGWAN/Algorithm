const fs = require("fs");
const { memoryUsage } = require("process");
const stdin = (process.platform === "linux"
  ? fs.readFileSync("/dev/stdin").toString()
  : `3
26 40 83
49 60 57
13 89 99
`
)
  .trim()
  .split("\n");

const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

N = Number(input());
arr = Array.from(Array(N+1), () => Array(3).fill(0))
for (let i=1; i<=N; i++) {
    let color = input().split(" ").map(x=>Number(x));
    arr[i][0] = Math.min(arr[i-1][1],arr[i-1][2])+color[0];
    arr[i][1] = Math.min(arr[i-1][0],arr[i-1][2])+color[1];
    arr[i][2] = Math.min(arr[i-1][0],arr[i-1][1])+color[2];
}
console.log(Math.min(...arr[N]));