#define WHITE	'-'
#define BLACK	'+'

class CwdWord;

struct CwdConnector
{
	CwdWord *connection;
	size_t startsAt;
	size_t connectsAt;
	CwdConnector(CwdWord* w, size_t st, size_t to) : connection(w), startsAt(st), connectsAt(to) {}
};

class CwdWord
{
public:
	CwdWord(size_t row, size_t col, bool horizontal, size_t length);
	~CwdWord();

	bool	isHorizontal;
	size_t  rowNumber;
	size_t  start;
	size_t  length;
	std::vector<CwdConnector*> connects;
};

CwdWord::CwdWord(size_t row, size_t col, bool horizontal, size_t len) :
	isHorizontal(horizontal),
	rowNumber(row),
	start(col),
	length(len)
	{}

CwdWord::~CwdWord()
{
}

class MyCrossword
{
public:
	MyCrossword(const std::vector<std::string>&);
	void addWords(std::string, size_t, bool);
	// bool itFits(const std::vector<std::string>&, const std::vector<size_t>&);
	bool itFits(const std::vector<std::string>&);

public:
	vector<CwdWord> places;
};

MyCrossword::MyCrossword(const std::vector<std::string> &puzzle)
{
	const size_t mySize = puzzle.size();
	if (puzzle[0].size() != mySize) exit(1);

	// scan H lines
	int hcnt = 0;
	for (auto row : puzzle)
	{
		this->addWords(row, hcnt, true);
		hcnt++;
	}

	// scan V lines
	for (size_t col = 0; col < mySize; col++)
	{
		std::string curr = "";
		for (size_t row = 0; row < mySize; row++)
			curr += puzzle[row].at(col);

		this->addWords(curr, col, false);
	}

	// find conections
	for (size_t i = 0; i < places.size(); i++)
	{
		size_t x = places[i].start, y = x + places[i].length - 1;

		for (size_t j = 0; j < places.size(); j++)
		{
			if (j == i) continue;

			// check crosses only
			if (places[i].isHorizontal == places[j].isHorizontal) continue;

			size_t x1 = places[j].start, y1 = x1 + places[j].length - 1;

			// connect
			if (places[i].rowNumber < x1 || places[i].rowNumber > y1) continue;
			if (places[j].rowNumber < x || places[j].rowNumber > y1) continue;

			places[i].connects.push_back(new CwdConnector(&places[j], places[j].rowNumber - x, places[i].rowNumber - x1));
		}

	}


}

void MyCrossword::addWords(std::string line, size_t index, bool isHorizontal)
{
	size_t i = 0;
	while (i < line.length())
	{
		if (line[i] == WHITE)
		{
			if (i < line.length() - 1 && line[i + 1] == WHITE)
			{
				size_t i1 = line.find(BLACK, i);
				size_t len = (i1 == string::npos) ? (line.length() - i) : (i1 - i);

				CwdWord *word;
				if (isHorizontal)
					word = new CwdWord(index, i, isHorizontal, len);
				else
					word = new CwdWord(index, i, isHorizontal, len);

				this->places.push_back(*word);

				i = (i1 == string::npos) ? line.length() : i + i1;

			}
		}

		i++;
	}

}

bool MyCrossword::itFits(const std::vector<std::string> &puzzle)
{
	if (puzzle.size() != places.size()) ERR("wrong argument");

	// test length
	for (size_t i = 0; i < places.size(); i++)
	{
		if (places[i].length != puzzle[i].length())
			return false;
	}

	for (size_t i = 0; i < places.size(); i++)
	{
		for (size_t j = 0; j < places[i].connects.size(); j++)
		{
			if (j == i) continue;
			if (places[i].isHorizontal == places[j].isHorizontal) continue;

			CwdConnector *cntr = places[i].connects[j];
			/*
			char test = puzzle[i].at(cntr->startsAt);
			PRN(test);
			char test2 = puzzle[j].at(cntr->connectsAt);
			PRN(test2);
			*/

			if (puzzle[i].at(cntr->startsAt) != puzzle[j].at(cntr->connectsAt))
				return false;
		}
	}

	return true;
}

vector<string> crosswordPuzzle(vector<string> crossword, string words) {

	MyCrossword cwd(crossword);

    std::replace(_R1(words), ';', ' ');
	istringstream strm(words);
	vector<string> puzzle
    string token;

	while (strm >> token)
	{
		puzzle.push_back(token);
	}

    PRN(words);

	vector<size_t> permutations;
	for (size_t i = 0; i < puzzle.size(); i++)
		permutations.push_back(i);

	do
	{
		vector<string> next = arrangeSolution(puzzle, permutations);

		// PRN(next);

		if (cwd.itFits(next))
		{
			for (size_t i = 0; i < cwd.places.size(); i++)
			{
				if (cwd.places[i].isHorizontal)
				{
					size_t ind = cwd.places[i].rowNumber;
					for (size_t k = 0; k < cwd.places[i].length; k++)
					{
						crossword[ind][k + cwd.places[i].start] = next[i][k];
					}
				}
			}

			PRN(next);
			break;
		}

	} while (std::next_permutation(_R1(permutations)));

}
