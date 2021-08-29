import sys
from pprint import pprint

import rusprofile


if __name__ == "__main__":
    p = rusprofile.RusprofileParser()
    p.get_stats()
    p.walk_all_pages()
    p.check_orgs()
    p.save_to_csv()
