import sys
import os
import xml.etree.ElementTree as ET


def check_arguments():
    """
    This function checks if number of arguments is correct.
    If number of arguments is incorrect, this function stops
    the execution.
    """
    if len(sys.argv) != 4:
        print("Invalid number of arguments")
        print("analyzer.py <repository-folder> <repository-url> <csv-report>")
        print("Current number of args: " + str(len(sys.argv)))
        exit(1)


def is_report_file(filename: str):
    """
    This function checks if a given file is a report file.
    """
    return filename.endswith(".xml")


def build_report(repository_folder, repository_url, report_file):
    """
    This function converts JUnit test results into the CSV file.
    """
    report_directory = os.path.dirname(report_file)
    if not os.path.exists(report_directory):
        os.makedirs(report_directory)
    report_file_d = open(report_file, "a")

    for (dirpath, dirnames, filenames) in os.walk(repository_folder):
        for filename in filenames:
            if is_report_file(filename):
                full_path = os.path.join(repository_folder, filename)
                build_report_for_file(full_path, repository_url, report_file_d)


def build_report_for_file(file_path: str, repository_url: str, report_file):
    report_tree = ET.parse(file_path)
    report_root = report_tree.getroot()
    report_name = report_root.attrib['name']
    report_status = "SUCCESS"
    if report_root.attrib['failures'] != '0' or report_root.attrib['errors'] != '0':
        report_status = "FAILURE"
    report_file.write(repository_url + ", " + report_name + ", " + report_status)
    report_file.write("\n")


if __name__ == '__main__':
    check_arguments()
    build_report(sys.argv[1], sys.argv[2], sys.argv[3])
