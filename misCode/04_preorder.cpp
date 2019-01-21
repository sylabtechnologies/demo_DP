// https://www.hackerrank.com/challenges/tree-preorder-traversal/problem

    void preOrder(Node *root) {

        cout << root->data << " ";

        if (root->left != nullptr)
            preOrder(root->left);

        if (root->right != nullptr)
            preOrder(root->right);

    }

    void postOrder(Node *root) {

        if (root->left != nullptr)
            postOrder(root->left);

        if (root->right != nullptr)
            postOrder(root->right);

        cout << root->data << " ";

    }

    void inOrder(Node *root) {

        if (root->left != nullptr)
            inOrder(root->left);

        cout << root->data << " ";

        if (root->right != nullptr)
            inOrder(root->right);

    }