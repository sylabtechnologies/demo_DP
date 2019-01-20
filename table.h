#pragma once
#include <vector>

template<typename T> class Table
{
public:
    Table(const size_t ysize, const size_t xsize)
    {
		std::vector<T> row;
        T empty;

        for (size_t i = 0; i < xsize; i++)
            row.push_back(empty);

        for (size_t i = 0; i < ysize; i++)
            _table.push_back(row);
    }

    T& at(const size_t i, const size_t j)
    {
		return _table.at(i).at(j);
    }

private:
	std::vector<std::vector<T>> _table;

};
