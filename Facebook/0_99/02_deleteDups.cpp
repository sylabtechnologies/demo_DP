struct ListNode
{
	int val;
	ListNode *next;
	ListNode(int x) : val(x), next(NULL) {}
};

void printList(ListNode* A)
{
	ListNode *current = A;

	while (current)
	{
		PRN(current->val);
		current = current->next;
	}
}

ListNode* deleteDuplicates(ListNode* A)
{
	ListNode *top = A;
	ListNode *current, *prev;

	prev = top;
	current = top->next;
	int count = 0;
	bool found = false;

	while (current)
	{
		if (prev->val == current->val)
		{
			count++;
		}
		else
		{
			if (count == 1)
				prev->next = current;

			count = 0;
			prev = current;
		}

		current = current->next;
	}

	if (count == 1)
		prev->next = current;

	return top;

	// Do not write main() function.
	// Still have a doubt. Checkout www.interviewbit.com/pages/sample_codes/ for more details
}

