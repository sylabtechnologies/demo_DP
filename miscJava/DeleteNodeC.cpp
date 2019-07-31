using namespace std;

class SinglyLinkedListNode {
    public:
        int data;
        SinglyLinkedListNode *next;

        SinglyLinkedListNode(int node_data) {
            this->data = node_data;
            this->next = nullptr;
        }
};

class SinglyLinkedList {
    public:
        SinglyLinkedListNode *head;
        SinglyLinkedListNode *tail;

        SinglyLinkedList() {
            this->head = nullptr;
            this->tail = nullptr;
        }

        void insert_node(int node_data) {
            SinglyLinkedListNode* node = new SinglyLinkedListNode(node_data);

            if (!this->head) {
                this->head = node;
            } else {
                this->tail->next = node;
            }

            this->tail = node;
        }

};

SinglyLinkedListNode deleteNode(SinglyLinkedList *list, int value)
{
        if (list == nullptr) return nullptr;
        
        SinglyLinkedList *prev = nullptr, *curr = list.head;
        while (curr->data != value)
        {
            if (curr->next == nullptr) return nullptr;
            prev = curr;
            curr = curr->next;
        }
        
        if (prev == nullptr)
            list->head = list->head->next;
        else
            prev->next = curr->next;
        
        curr->next = nullptr;
        return curr;
}

int main()
{
    SinglyLinkedList* lst = new SinglyLinkedList();

    for (size_t i = 0; i < 5; i++)
    {
        int nextItem;
        cin >> nextItem;
        lst->insert_node();
    }

    SinglyLinkedListNode answer = deleteNode(lst, 5);
    if (answer != nullptr)
        cout << answer.data;
    else
        cout << "not found";
    cout << endl;

    return 0;
}
