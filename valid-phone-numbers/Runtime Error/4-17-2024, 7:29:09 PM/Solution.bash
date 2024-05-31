// https://leetcode.com/problems/valid-phone-numbers

# Read from the file file.txt and output all valid phone numbers to stdout.
import re

# Function to validate a phone number
def is_valid_phone_number(phone_number):
  """
  Checks if a given string is a valid phone number in a specific format.

  Args:
      phone_number (str): The phone number string to validate.

  Returns:
      bool: True if the phone number is valid, False otherwise.
  """
  pattern = r"^\d{3}-\d{3}-\d{4}$"  # Regex pattern for ###-###-#### format
  return bool(re.match(pattern, phone_number))

# Simulate reading phone numbers from a file (replace with actual file reading logic)
phone_numbers = ["123-456-7890", "invalid-number", "5551234567"]

# Validate and print valid phone numbers
for phone_number in phone_numbers:
  if is_valid_phone_number(phone_number):
    print(phone_number)
