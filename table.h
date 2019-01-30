#pragma once
#include <vector>

template<typename T> class Table
{
public:
    Table(const size_t ysize, const size_t xsize)
    {
		std::vector<T> row(xsize);
        _table = vector<std::vector<T>>(ysize, row);
    }

    T& at(const size_t i, const size_t j)
    {
		return _table.at(i).at(j);
    }

private:
	std::vector<std::vector<T>> _table;

};
