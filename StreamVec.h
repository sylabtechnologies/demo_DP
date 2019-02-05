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

	myvec.clear();

	size_t i;
	while (i < vecSize)
	{
		T temp;
		iis >> temp;

		if (!iis.good()) throw std::runtime_error("Vector I/O failure");

		// cant emplace_back here
		myvec.push_back(temp);
		i++
	}

	if (i != vecSize) throw std::runtime_error("Vector cant be filled");

	return iis;
}