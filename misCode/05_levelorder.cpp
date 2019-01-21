// https://www.hackerrank.com/challenges/tree-level-order-traversal/problem

    void levelOrder(Node* root) {
        queue<Node*> q;
        int levelNodes = 0;

        if (root == nullptr) return;

        q.push(root);

        while(!q.empty())
        {
            levelNodes = q.size();

            while(levelNodes > 0)
            {
                Node* n = q.front();
                q.pop();
                cout << n->data << " ";

                if(n->left != nullptr)  q.push(n->left);

                if(n->right != nullptr) q.push(n->right);
                
                levelNodes--;
            }
        }

        cout << endl;

    }