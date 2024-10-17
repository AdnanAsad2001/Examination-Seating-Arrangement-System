DROP TABLE IF EXISTS "absentees";
CREATE TABLE "absentees" (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  studentregno TEXT NOT NULL,
  examid INTEGER NOT NULL);

DROP TABLE IF EXISTS "batches";
CREATE TABLE "batches" (
  "id" INTEGER PRIMARY KEY NOT NULL,
  "name" TEXT NOT NULL,
  "schemeid" TEXT NOT NULL);

DROP TABLE IF EXISTS "departments";
CREATE TABLE "departments" (
  "id" TEXT PRIMARY KEY NOT NULL,
  "name" TEXT NOT NULL);

DROP TABLE IF EXISTS "examdutystaffs";
CREATE TABLE "examdutystaffs" (
  "id" INTEGER PRIMARY KEY AUTOINCREMENT,
  "staffid" TEXT NOT NULL,
  "examid" INTEGER NOT NULL);

DROP TABLE IF EXISTS "exams";
CREATE TABLE "exams" (
  "id" INTEGER PRIMARY KEY AUTOINCREMENT,
  "name" TEXT UNIQUE NOT NULL,
  "date" TEXT NOT NULL,
  "time" TEXT NOT NULL,
  "description" TEXT DEFAULT NULL);

DROP TABLE IF EXISTS "examsubjectandbatches";
CREATE TABLE "examsubjectandbatches" (
  "id" INTEGER PRIMARY KEY AUTOINCREMENT,
  "examid" INTEGER NOT NULL,
  "subjectid" INTEGER NOT NULL,
  "batchid" INTEGER NOT NULL);

DROP TABLE IF EXISTS "halls";
CREATE TABLE "halls" (
  "id" INTEGER PRIMARY KEY AUTOINCREMENT,
  "name" TEXT NOT NULL,
  "noofrow" INTEGER NOT NULL,
  "noofcol" INTEGER NOT NULL,
  "description" TEXT DEFAULT NULL);

DROP TABLE IF EXISTS "login";
CREATE TABLE "login" (
  "uname" TEXT PRIMARY KEY NOT NULL,
  "upass" TEXT NOT NULL,
  "uloginname" TEXT NOT NULL,
  "utype" TEXT NOT NULL,
  "udescription" TEXT DEFAULT NULL);

INSERT INTO "login" VALUES ("ADNAN", "249", "ADNAN_5959", "admin", "ADNAN ASAD");
INSERT INTO "login" VALUES ("ADMIN", "ADMIN", "ADMIN", "admin", "ADMIN");
INSERT INTO "login" VALUES ("user", "user", "USER", "user", "USER");

DROP TABLE IF EXISTS "nonregisteredstudents";
CREATE TABLE "nonregisteredstudents" (
  "id" INTEGER PRIMARY KEY AUTOINCREMENT,
  "studentregno" TEXT NOT NULL,
  "examid" INTEGER NOT NULL);

DROP TABLE IF EXISTS "schemes";
CREATE TABLE "schemes" (
  "id" TEXT PRIMARY KEY NOT NULL,
  "description" TEXT DEFAULT NULL);

DROP TABLE IF EXISTS "seatings";
CREATE TABLE "seatings" (
  "id" INTEGER PRIMARY KEY AUTOINCREMENT,
  "examid" INTEGER NOT NULL,
  "studentregno" TEXT NOT NULL,
  "hallname" TEXT NOT NULL,
  "seatno" TEXT NOT NULL);

DROP TABLE IF EXISTS "selectedexamhalls";
CREATE TABLE "selectedexamhalls" (
  "id" INTEGER PRIMARY KEY AUTOINCREMENT,
  "hallname" TEXT NOT NULL,
  "examid" INTEGER NOT NULL);

DROP TABLE IF EXISTS "staffs";
CREATE TABLE "staffs" (
  "id" TEXT PRIMARY KEY NOT NULL,
  "name" TEXT NOT NULL,
  "deptid" TEXT NOT NULL,
  "description" TEXT DEFAULT NULL);

DROP TABLE IF EXISTS "students";
CREATE TABLE "students" (
  "regno" TEXT PRIMARY KEY NOT NULL,
  "name" TEXT NOT NULL,
  "batchid" TEXT NOT NULL,
  "deptid" TEXT NOT NULL);

DROP TABLE IF EXISTS "subjects";
CREATE TABLE "subjects" (
  "id" TEXT PRIMARY KEY NOT NULL,
  "name" TEXT NOT NULL,
  "schemeid" TEXT NOT NULL,
  "semester" TEXT NOT NULL,
  "description" TEXT DEFAULT NULL);