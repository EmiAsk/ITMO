def convert_array(obj: list, indent=0):
    result = []

    for value in obj:

        if isinstance(value, dict):
            part = convert_dict(value, indent + 2)

        elif isinstance(value, list):
            part = convert_array(value, indent + 2)
            part = ('- ' * bool(value)) + part

        else:
            part = str(value)

        result.append(part)

    if not result:
        return '[]'

    sep = '\n' + indent * ' ' + '- '

    return sep.join(result)


def convert_dict(obj: dict, indent=0):
    result = []

    for key, value in obj.items():

        if isinstance(value, dict):
            part = convert_dict(value, indent + 2)
            spaces = ' ' * (indent + 2)
            result.append(f'{key}:\n{spaces}{part}')

        elif isinstance(value, list):
            part = convert_array(value, indent + 2)
            spaces = ' ' * (indent + 2)
            result.append(f'{key}:\n{spaces}- {part}')

        else:
            result.append(f'{key}: {value}')
            continue

    sep = '\n' + indent * ' '
    return sep.join(result)


def convert_to_yaml(json_object):

    if isinstance(json_object, dict):
        return convert_dict(json_object)

    elif isinstance(json_object, list):
        return '- ' + convert_array(json_object)

    return str(json_object)
