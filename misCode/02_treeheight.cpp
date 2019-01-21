// https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem

    int height(Node* root)
    {

        if (root->left == nullptr)
        {
            if (root->right == nullptr ) return 0;

            return height(root->right) + 1;
        }

        if (root->right == nullptr)
            return height(root->left) + 1;
        

        return std::max(height(root->left),height(root->right))  + 1;
    }
