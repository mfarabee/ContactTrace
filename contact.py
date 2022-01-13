#a Simple program to read gps coordinates and time for contract tracing
# Input file format:
#  Name1
#  + longitude latitude time
#  + longitude latitude time
#  + longitude latitude time
#  Name2
#  + longitude latitude time
#  + longitude latitude time
#  + longitude latitude time

from operator import ne
from sys import stdout
import struct
from tkinter import W
import os.path

LOCATION_RESOLUTION = 1
TIME_RESOLUTION = 1

def nearTime(x,y):
    result=False
    if abs(x-y)<= TIME_RESOLUTION:
        result=True
    return(result)

def near(x,y):
    result=False
    if abs(x-y)<= LOCATION_RESOLUTION:
        result=True
    return(result)

class Location:
    def __init__(self,lat,long,myTime):
        self.lat=lat
        self.long=long
        self.myTime=myTime

    def getLat(self):
        return(self.lat)

    def getLong(self):
        return(self.long)

    def getTime(self):
        return(self.myTime)

class Student(Location):
    def __init__(self,name):
            self.name=name
            self.locationList=[]

    def getName(self):
        return self.name

    def addGPS(self,lat,long,myTime):
        loc = Location(lat,long,myTime)        
        self.locationList.append(loc)

    def printGPS(self):
        for index in range(0,len(self.locationList)):
            print (self.locationList[index].getLat() ,self.locationList[index].getLong() , self.locationList[index].getTime(), sep="  "); 
    
    def getGPSList(self):
        return(self.locationList)

    def compareGPS(self,coord):
        result=False
        for point in self.locationList:
            if near(point.getLat(),coord.getLat()) and near(point.getLong(),coord.getLong()) and nearTime(point.getTime(),coord.getTime()):
                result=True
        return(result)


class StudentBody(Student):
    def __init__(self):
        self.StudentList=[]
    
    def addStudent(self,name):
        newStudent= Student(name)
        self.StudentList.append(newStudent)
        return(newStudent)

    def removeStudent(self): # could be used to remove students, if needed
        pass

    def readData(self,fileName):
        f=open(fileName,"r")
        for line in f:
            line = line.strip()
            if line !="" :
                if line[0] != "+":
                   person=self.addStudent(line) 
                else:
                    if(line[0] == "+"):
                        tmp=line.split(" ")
                        person.addGPS(float(tmp[1]),float(tmp[2]),float(tmp[3]))
        f.close()

    def getStudentByName(self,name):
        result=None
        for count in range(0,len(self.StudentList)):
            if(self.StudentList[count].getName() == name):
                result=self.StudentList[count]
                break
        return(result)

    def findContact(self,name):
        patientZero=self.getStudentByName(name)
        if patientZero != None:
            for person in self.StudentList:
                if (person != patientZero): # Check all students that are not patient zero
                    for pzCoord in patientZero.getGPSList():  # loop through patient zeros location and compare to person
                        if person.compareGPS(pzCoord) == True:
                            print(name,person.getName(),sep=" <--> ")
                            break
        else:  # Check if student exists
            print(name," is not a student")


# Test routine to add students
def test(mySchool):
    tmp=mySchool.addStudent("Tom")
    tmp.addGPS(0,0,4)
    tmp.addGPS(1,0,4)
    tmp.addGPS(1,1,4)
    tmp=mySchool.addStudent("Dick")
    tmp.addGPS(1,0,1)
    tmp.addGPS(2,0,2)
    tmp.addGPS(2,1,2)
    tmp=mySchool.addStudent("Harry")
    tmp.addGPS(3,0,1)
    tmp.addGPS(3,1,2)
    tmp.addGPS(3,2,2)


if __name__ == "__main__":

    # Create a new student body
    mySchool= StudentBody()

    # load student information from a file
    mySchool.readData("students.txt")
    mySchool.findContact("Jett")