#pragma once

template<typename T> std::ostream& operator<< (std::ostream& os, std::vector<T>& myvec)
{
	if (!myvec.empty())
	{
		os << "[ ";

		for (size_t i = 0; i < myvec.size() - 1; i++)
		{
			os << myvec[i] << ", ";
		}

		os << myvec[myvec.size() - 1] << " ]";
	}
	else
	{
		os << "[]";
	}

	return os;
}

template<typename T> std::istream& operator>> (std::istream& iis, std::vector<T>& myvec)
{
	size_t vecSize = myvec.size();

	myvec.clear(); myvec.resize(vecSize);

	for (auto &elem : myvecSize)
	{
		iis >> elem;

		if (!iis.good()) throw std::out_of_range("Vector I/O failure");
	}

	return iis;
}