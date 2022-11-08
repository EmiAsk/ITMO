# def convert_array(obj: list, indent=0):
#     result = ''
#
#     for value in obj:
#         if isinstance(value, dict):
#             part = convert_dict(value)
#         elif isinstance(value, list):
#             part = convert_array(value, indent + 2)
#         else:
#             part = value
#
#         result += (' ' * indent) + f'- {part}\n'
#
#     return result if result else '[]'
#
#
# def convert_dict(obj: dict, indent=0):
#     result = ''
#
#     for k, (key, value) in enumerate(obj.items()):
#         if isinstance(value, dict):
#             part = convert_dict(value, indent + 6)
#         elif isinstance(value, list):
#             part = convert_array(value, indent + 2)
#         else:
#             if k == 0:
#                 result += f'{key}: {value}\n'
#                 continue
#             result += (' ' * indent) + f'{key}: {value}\n'
#             continue
#
#         if k == 0:
#             result += f'{key}:\n{part}\n'
#             continue
#
#         result += (indent * ' ') + f'{key}:\n{part}\n'
#
#     return result if result else '{}'
def convert_array(obj: list, indent=0):
    result = []

    for value in obj:
        if isinstance(value, dict):
            part = convert_dict(value, indent + 2)
        elif isinstance(value, list):
            part = convert_array(value, indent + 2)
        else:
            part = str(value)

        result.append(part)

    sep = '\n' + indent * ' ' + '- '

    return sep[1:] + sep.join(result)


def convert_dict(obj: dict, indent=0):
    result = []

    for k, (key, value) in enumerate(obj.items()):
        if isinstance(value, dict):
            part = convert_dict(value, indent + 2)
        elif isinstance(value, list):
            part = convert_array(value, indent + 2)
        else:
            result.append((' ' * indent) + f'{key}: {value}')
            continue

        result.append((indent * ' ') + f'{key}:\n{part}\n')

    sep = '\n' + indent * ' '
    return sep + sep.join(result)


def convert_to_yaml(json_object):
    if isinstance(json_object, dict):
        return convert_dict(json_object)
    elif isinstance(json_object, list):
        return convert_array(json_object)

    return str(json_object)
