#pragma once

// magic statics are thread safe
class Singleton
{
public:
	static Singleton* getInstance()
	{
		if (instance == nullptr) instance = new Singleton(); return instance;
	}
	Singleton(const Singleton&) = delete;
	Singleton& operator=(const Singleton&) = delete;

private:
	static Singleton* instance;
	Singleton() {};

};

// add Singleton* Singleton::instance = nullptr; to the project cpp

