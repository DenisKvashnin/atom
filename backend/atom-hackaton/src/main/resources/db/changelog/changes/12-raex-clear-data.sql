UPDATE raex_dict SET full_name = translate(full_name, '"\"', '');
UPDATE raex_dict SET full_name = translate(full_name, ' ', '');