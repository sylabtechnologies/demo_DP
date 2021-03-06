// https://www.hackerrank.com/challenges/find-the-nearest-clone/problem

#include <bits/stdc++.h>

using namespace std;

typedef list<int> Mylist;
typedef vector<int> Myvector;

class Graph {
public:
  Graph(int n, const Myvector &);
  ~Graph();

  void addEdge(int, int);
  void bfsColor(int);

private:
  int bfsMinDistance(int, int);
  int findColor(int); // find this color

private:
  int _numVertices;
  Mylist *_adjacencyList;
  Myvector _colorId;
  Myvector _visited;
};

Graph::Graph(int v, const Myvector &color) {
  _numVertices = v;
  _adjacencyList = new Mylist[v];

  if (color.size() != v)
    throw runtime_error("incomplete color id");

  std::copy(color.begin(), color.end(), back_inserter(_colorId));

  _visited.resize(_numVertices);

  return;
}

Graph::~Graph() { delete[] _adjacencyList; }

void Graph::addEdge(int v, int w) {
  // use zero base
  v--;
  w--;

  _adjacencyList[v].push_back(w);
  _adjacencyList[w].push_back(v);
}

// BFS-traverse from node of color
int Graph::findColor(int seekColor) {
  int resultNode = -1;

  for (size_t i = 0; i < _colorId.size(); i++)
    if (seekColor == _colorId[i]) {
      resultNode = i;
      break;
    }

  return resultNode;
}

void Graph::bfsColor(int seekColor) {
  for (size_t i = 0; i < _numVertices; i++)
    _visited[i] = 0;

  int nextNode = findColor(seekColor);

  Mylist answers;
  while (nextNode >= 0) {
    int min = bfsMinDistance(nextNode, seekColor);

    // shortcut for ones
    if (min == 1) {
      cout << min << endl;
      return;
    }

    if (min >= 0)
      answers.push_back(min);

    _colorId[nextNode] = -1; // null that
    nextNode = findColor(seekColor);
  }

  if (answers.empty())
    cout << "-1" << endl;
  else
    cout << *min_element(answers.begin(), answers.end()) << endl;

  return;
}

int Graph::bfsMinDistance(int start, int seekColor) {
  Mylist bfs_queue;
  Myvector distance(_numVertices, 0);

  // enque start
  bfs_queue.push_back(start);

  while (!bfs_queue.empty()) {
    int s;

    // deque front
    s = bfs_queue.front();
    _visited[s] = 1;
    bfs_queue.pop_front();

    // enque all adjacent
    for (auto iter = _adjacencyList[s].begin(); iter != _adjacencyList[s].end();
         ++iter) {
      if (_visited[*iter] == 0) {
        _visited[*iter] = 1;
        distance[*iter] = distance[s] + 1;

        if (_colorId[*iter] == seekColor)
          return distance[*iter];

        bfs_queue.push_back(*iter);
      }
    }
  }

  return -1;
}

int main() {
  ifstream cin("sample.txt");

  int numNodes, numEdges;
  cin >> numNodes >> numEdges;

  vector<pair<int, int>> edges;
  while (numEdges > 0) {

    int u, v;
    cin >> u >> v;
    edges.push_back(make_pair(u, v));
    numEdges--;
  }

  Myvector color;
  for (int i = 0; i < numNodes; i++) {
    int c;
    cin >> c;
    color.push_back(c);
  }

  Graph g(numNodes, color);

  for (auto &elem : edges)
    g.addEdge(elem.first, elem.second);

  int findColor;
  cin >> findColor;
  g.bfsColor(findColor);

  return 0;
}

