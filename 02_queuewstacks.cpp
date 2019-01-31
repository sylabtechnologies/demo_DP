// https://www.hackerrank.com/challenges/queue-using-two-stacks/problem

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <stack>
using namespace std;

#define INT_MIN -2000000000;

class MyQueue
{
private:
    std::stack<int> queue;
    std::stack<int> temp;

    void queue2temp();
    void temp2queue();

public:
    void enqueue(int);
    int dequeue();
    int front();
};

void MyQueue::enqueue(int val)
{
    queue.push(val);
}

int MyQueue::dequeue()
{
    if (queue.empty()) return INT_MIN;

    queue2temp();

    int ans = temp.top();
    temp.pop();
    temp2queue();

    return ans;
}

int MyQueue::front()
{
    if (queue.empty()) return INT_MIN;

    queue2temp();
    int ans = temp.top();
    temp2queue();

    return ans;
}

// invert
void MyQueue::queue2temp()
{
    while (!queue.empty())
    {
        int val = queue.top();
        temp.push(val);
        queue.pop();
    }
}

// & back
void MyQueue::temp2queue()
{
    while (!temp.empty())
    {
        enqueue(temp.top());
        temp.pop();
    }
}

int main() {
    MyQueue qq;

    int numQueries; cin >> numQueries;

    for (size_t i = 0; i < numQueries; i++)
    {
        int type, val;
        
        cin >> type;

        switch (type)
        {
        case 1:
            cin >> val;
            qq.enqueue(val);
            break;

        case 2:
            qq.dequeue();
            break;

        case 3:
            cout << qq.front() << endl;
            break;


        default:
            break;
        }


    }

    return 0;
}
