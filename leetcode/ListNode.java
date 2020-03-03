#include <iostream>
#include <vector>
#include <boost/asio.hpp>
using boost::asio::io_service;
using boost::asio::buffer;
using boost::asio::ip::udp;

int main(int argc, char* argv[])
{
	// simple messaging to sockets

	// common! BEST BOOK:https://docplayer.net/53966455-Learning-boost-c-libraries-by-arindam-mukherjee-download-ebook-learning-boost-c-libraries-by-arindam-mukherjee-pdf.html
	// ie 123 works just get oo objects
    // https://books.google.com/books?id=G6JNCgAAQBAJ&pg=PA461&lpg=PA461&dq=boost+synchronous+%22udp+server%22&source=bl&ots=3jN-vtxWsx&sig=ACfU3U1-l2p5pPEl8BLAQnfNpEs2YzOHSQ&hl=en&sa=X&ved=2ahUKEwi9w9nHk_XnAhXilXIEHTxJC-wQ6AEwAnoECAoQAQ#v=onepage&q=boost%20synchronous%20%22udp%20server%22&f=false

	io_service service;
	udp::endpoint myEndpt(udp::v4(), 1111), ep;
	udp::socket sock(service, myEndpt);

	while (true)
	{
		try
		{
			char msg[256];
			auto recvd = sock.receive_from(buffer(msg, sizeof(msg)), ep);
			std::string packet(msg, msg + recvd);
			std::cout << "Received " << packet << std::endl;
		}
		catch (std::exception& e)
		{
			std::cout << e.what() << std::endl;
		}

			
	}

	return 0;
}


package mergelists;

/**
 * interface?
 * implementation?
 */

class ListNode
{
    int val;
    ListNode next;
    ListNode(int x)
    {
        val = x;
    }
    
    void add(ListNode next)
    {
        this.next = next;
    }
    
    @Override
    public String toString()
    {
        ListNode curr = this;
        StringBuilder sb = new StringBuilder();

        while (curr != null)
        {
            sb.append(curr.val);
            sb.append(" ");
            curr = curr.next;
        }
        
        return sb.toString();
    }
    
}
