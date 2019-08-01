using namespace std;

struct Node {
    int data;
    Node *next;
    Node(int node_data) {this->data = node_data; this->next = nullptr;}
};

Node deleteNode(Node *&head, int value)
{
    if (head == nullptr) return nullptr;

    Node *prev = head, *curr;

    // shift right
    if (head->data == value)
    {
        curr = head;
    }
    else
    {
        if (head->next == nullptr) return nullptr;

        prev = head;
        curr = head->next;
        while (curr->data != value)
        {
            if (curr->next == nullptr) return nullptr;
            prev = curr;
            curr = curr->next;
        }
    }

    prev->next = curr->next;
    curr->next = nullptr;
    return curr;
}
