let capitals = new Map();
capitals.set('MH', 'mumbai')
capitals.set('GJ', 'GNR')
capitals.set('TL', 'Hyd')
capitals.set('TN', 'chennai')
capitals.set('MH', 'pune')
 
console.log(capitals.entries())
console.log(capitals.keys())
console.log(capitals.values())
console.log(capitals.get('GJ'))
 
let hobbies = new Set()
hobbies.add('swimming')
hobbies.add('running')
hobbies.add('cycling')
hobbies.add('swimming')
hobbies.add('swimming')
 
console.log(hobbies)
console.log(hobbies.has('sdfgsdfgds'))
console.log(hobbies.values())


 
let score = [10, 20, 30, 40]
let score1 = Array.of(10, 20, 30, 40)
 
let isPresent = score.find(function (x) {
    return x === 30
})
console.log('30 is present or not: ', isPresent)